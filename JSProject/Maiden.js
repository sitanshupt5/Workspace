let array = [88,87,90,94,96]
console.log(array)

let totalMarks = array.reduce((sum,marks)=>sum+marks,0)
console.log(totalMarks)

let evenScores=array.filter(mark=>mark%2==0)
console.log(evenScores)

let decimal = array.map(marks=>marks/100)
console.log(decimal)

let percentage = totalMarks/array.length
console.log(percentage)