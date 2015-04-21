function timeDisplay() {
    var date = new Date();
    var currentTime = date.getHours() + ":" + (date.getMinutes() < 10 ? '0' : '') +
        date.getMinutes();
    //alert(currentTime);
    console.log(currentTime);
}
timeDisplay();