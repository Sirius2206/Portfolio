

function parseCount (num) {
    if (!isNaN(Number.parseInt(num))){
        return +num;
    }
    throw new Error ("Невалидное значение"); 
}

function validateCount (num) {
    try {
        parseCount(num);
        return +num;
    } catch (e) {
        return e;
    }
}
class Triangle {

    constructor (a, b, c) {
        if ((a >= b + c) || (b >= a + c) || (c >= a + b)) {
            throw new Error ("Треугольник с такими сторонами не существует");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    getPerimeter () {
        return +(this.a + this.b + this.c);
    }

    getArea() {
        let p = (this.a + this.b + this.c) / 2;
        let area = Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
        return +area.toFixed(3);
    }

}

function getTriangle(a, b, c) {
    try {
        let resultTriangle = new Triangle(a, b, c);
        return resultTriangle;
    } catch(e) {
        let result = {
            getArea: () => "Ошибка! Треугольник не существует",
            getPerimeter: () => "Ошибка! Треугольник не существует"
        }
        return result;
    }
}