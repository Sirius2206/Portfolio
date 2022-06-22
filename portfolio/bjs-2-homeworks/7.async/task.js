class AlarmClock {
        alarmCollection = [];
        timerId = null;
        isPaused = false;

    addClock (time, callback, id) {
        if (id === undefined) {
            throw new Error ("Отсутствует идентификатор создаваемого звонка");
        }

        let check = this.alarmCollection.some((obj) => obj.id === id);
        if (check) {
            console.error("Будильник с заданным id уже существует");
            return;
        }
        const resultClock = {
            id: id,
            time: time,
            callback: callback
        }
        this.alarmCollection.push(resultClock);
    }

    removeClock (id) {
        const prevLength = this.alarmCollection.length;
        this.alarmCollection = this.alarmCollection.filter((obj) => {obj.id !== id;})
        if (this.alarmCollection.length < prevLength) {
            console.log(`Будильник с id = ${id} удален.`)
            return;
        }
        console.log("Не удалось найти будильник с таким id");
        return;
    }

    getCurrentFormattedTime () {
        const dateStr = this.getFormattedTime(new Date());
        return dateStr;
    }

    getFormattedTime(date) {
        const hour = (date.getHours() < 10) ? '0' + date.getHours() : date.getHours();
        const minute = (date.getMinutes() < 10) ? '0' + date.getMinutes() : date.getMinutes();
        const result = `${hour}:${minute}`;
        return result;
    }

    checkClock(clock) {
        if (clock.time === this.getCurrentFormattedTime()) {
            this.isPaused = true;
            let alarm = setInterval(() => clock.callback(), 1000);
            setTimeout(() => {clearInterval(alarm); this.isPaused = false;}, 60000);
        }
    }

    start() {
        this.timerId = setInterval(() => {
            if (!this.isPaused) {
                this.alarmCollection.forEach((alarm) => this.checkClock(alarm))
            }
        }, 1000);
    }

    stop() {
        if (this.timerId) {
            clearInterval(this.timerId);
            this.timerId = null;
        }
    }

    printAlarms() {
        console.log(`Печать всех будильников в количестве: ${this.alarmCollection.length}`);
        this.alarmCollection.forEach((alarm) => {
            console.log(`Будильник №${alarm.id} заведен на ${alarm.time}`);   
        })
    }

    clearAlarms() {
        clearInterval(this.timerId);
        this.alarmCollection.length = 0;
    }
}
