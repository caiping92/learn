//
// Created by ccc25 on 2019/11/10.
//

#include "demo_data_type.h"

#include <iostream>


void t_void() {

    std::cout << "Demo void:  " << std::endl;

    int32_t a = 123;
    std::cout << "a: " << a << std::endl;

    void *b = &a;


    int *c = (int32_t *) b;
    std::cout << "c: " << *c << std::endl;
    *c = -255;

    std::cout << "----------" << std::endl;
    std::cout << "a: " << a << std::endl;
    std::cout << "c: " << *c << std::endl;


    bool *d = (bool *) b;
    std::cout << "d: " << *d << std::endl;
    char  *e = (char *) b;
    std::cout << "e: " << *e << std::endl;

}


void learn::demo::demo_data_type::run() {

    t_void();

}

void learn::demo::demo_data_type::name(std::string &name) {

    name = "Data Type";

}
