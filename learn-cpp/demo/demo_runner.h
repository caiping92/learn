//
// Created by ccc25 on 2019/11/10.
//

#ifndef LEARN_CPP_DEMORUNNER_H
#define LEARN_CPP_DEMORUNNER_H

#include <list>
#include <memory>
#include <string>

namespace learn {

    namespace demo {

        class demo_runner {
        public:
            virtual void run() {}
            virtual void name(std::string &name){}
        };
        static std::list<std::shared_ptr<demo_runner>> demos;
        void init_demo();
        void start_demo();

    }

}

#endif //LEARN_CPP_DEMORUNNER_H
