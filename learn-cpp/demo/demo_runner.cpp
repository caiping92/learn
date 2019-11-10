//
// Created by ccc25 on 2019/11/10.
//

#include "demo_runner.h"

#include <iostream>
#include <demo_opp.h>


void learn::demo::start_demo() {

    using namespace learn::demo;
    using namespace std;
    init_demo();

    if (demos.empty()) {
        cout << "theare is no demo";
        return;
    }
    int32_t i = 0;
    for (auto itr = demos.begin(); itr != demos.end();) {
        cout << "***************************" << endl;
        std::string name_;
        itr->get()->name(name_);
        cout << "Start Run Demo-" << ++i << ": " << name_ << endl;
        cout << "***************************" << endl;
        itr->get()->run();
        learn::demo::demos.erase(itr++);
    }

}

void learn::demo::init_demo() {

    //*************************
    // 添加demo
    //*************************
    std::shared_ptr<OOP> ptrDemoOOP = std::make_shared<OOP>();
    demos.push_back(ptrDemoOOP);



}

