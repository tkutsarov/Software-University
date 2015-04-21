function CircleArea(radius) {
    var area = Math.PI * radius * radius;
    return area;
}
document.write("r = 7; area = " + CircleArea(7));
document.write("<br>");
document.write("r = 1.5; area = " + CircleArea(1.5));
document.write("<br>");
document.write("r = 20; area = " + CircleArea(20));
