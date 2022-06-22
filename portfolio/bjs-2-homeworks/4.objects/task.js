function Student(name, gender, age) {
    this.name = name;
    this.gender = gender;
    this.age = age;

}

Student.prototype.setSubject = function (subjectName) {
  this.subject = subjectName;
}

Student.prototype.addMark = function (mark) {
  if (this.marks === undefined) {
    this.marks = [];
  }
  this.marks.push(mark);
}

Student.prototype.addMarks = function(...all){
  if (this.marks === undefined) {
    this.marks = [];
  }
  all.forEach(mark => {
    this.marks.push(mark)
  });
}

Student.prototype.getAverage = function() {
  if (this.marks === undefined) return 0;
  let sum = 0;
  this.marks.forEach(mark => {
    sum += mark;
  })
  return sum / this.marks.length;
}

Student.prototype.exclude = function(reason) {
  delete(this.marks);
  delete(this.subject);
  this.excluded = reason;
}