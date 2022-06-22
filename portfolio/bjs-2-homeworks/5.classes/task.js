class PrintEditionItem {
    constructor (name, releaseDate, pagesCount, state = 100) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.pagesCount = pagesCount;
        this._state = state;
        this.type = null;
    }

    fix() {
        this.state = this.state * 1.5;
    }

    set state (state) {
        this._state = (state < 0) ? 0 : (state > 100) ? 100 : state;

    }

    get state () {
        return this._state;
    }
}

class Magazine extends PrintEditionItem {
    constructor (name, releaseDate, pagesCount, state = 100) {
       super(name, releaseDate, pagesCount, state = 100);
        this.type = "magazine";
    }
}

class Book extends PrintEditionItem {
    constructor (author, name, releaseDate, pagesCount, state = 100) {
        super(name, releaseDate, pagesCount, state = 100);
        this.author = author;
        this.type = "book";
    }
}
class NovelBook extends Book {
    constructor (author, name, releaseDate, pagesCount, state = 100) {
        super(author, name, releaseDate, pagesCount, state = 100);
        this.type = "novel";
    }
}

class FantasticBook extends Book {
    constructor (author, name, releaseDate, pagesCount, state = 100) {
        super(author, name, releaseDate, pagesCount, state = 100);
        this.type = "fantastic";
    }
}

class DetectiveBook extends Book {
    constructor (author, name, releaseDate, pagesCount, state = 100) {
        super(author, name, releaseDate, pagesCount, state = 100);
        this.type = "detective";
    }
}

class Library {
    constructor (name) {
        this.name = name;
        this.books = [];
    }

    addBook (book) {
        if (book instanceof PrintEditionItem) {
            if (book.state >= 30) {
                this.books.push (book);
            }
        }
    }

    findBookBy (type, value) {
        let result = null;
        this.books.forEach(book => {
            if (book[type] === value) {
                result = book;
                return result;
            }
        })
        return result;
    }

    giveBookByName (bookName) {
        for (let i = 0; i < this.books.length; i++) {
            if (this.books[i].name === bookName) {
                let result = this.books[i];
                this.books.splice(i, 1);
                return result;
            }
        }
        return null;
    }
}


class Student {
    constructor (name) {
        this.name = name;
    }

    disciplines = {};

    addMark (mark, subject) {
        if (!this.disciplines?.[subject]) {
            this.disciplines[subject] = [];
        }
        if (mark < 1 || mark > 5) {
            console.log("Ошибка, оценка должна быть числом от 1 до 5");
            return;
        }
        this.disciplines[subject].push(mark);
    }

    getAverageBySubject (subject) {
        if (!this.disciplines?.[subject]) {
            console.log ("Несуществующий предмет");
            return;
        }
        let sum = 0;
        this.disciplines[subject].forEach(el => {
            sum += el;
        })
        return sum / this.disciplines[subject].length;
    }

    
    getAverage () {
        let sum = 0;
        let marksCount = 0;
        for (let sub in this.disciplines) {
            this.disciplines[sub].forEach (el => {
                sum += el;
                marksCount++;
            })
        }
        return sum / marksCount;
    }

    printGrades () {
        for (let sub in this.disciplines) {
            console.log(`Оценки по предмету ${sub}: ${this.disciplines[sub]}`);
        }
    }

    exclude (reason) {
        delete(this.disciplines);
        this.excluded = reason;
    }
}