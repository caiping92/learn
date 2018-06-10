/*
 for(var i=0;i<5;i++){
 setTimeout((function(i){
 console.log(i);
 })(i),i*1000);
 }
 */

/*

 for(var i=0;i<5;i++){
 (function(){
 setTimeout(function(i){
 console.log(i);
 },i*1000);
 })(i);
 }*/


var a = 2;
var obj = {
    b: 2
};
var fn = function () {

}
fn.c = 3;
function change(i, j, k) {
    i = 3;
    j.b = 5;
    k.c = 6;
}
change(a, obj, fn);
// debug(a + obj.b + fn.c);
console.log(a + obj.b + fn.c);