namespace java hello
namespace py hello

/*
c like comments are supported
 */
 // this is also valid comment
 typedef i32 int // we can use typedef to get pretty names for the types we are using
 service MultipalicationService
 {
    int multiply(1:int n1,2:int n2),
 }