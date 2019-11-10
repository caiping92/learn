//
// Created by caiping on 2019/4/5.
//

#ifndef LEARN_CPP_OPP_H
#define LEARN_CPP_OPP_H

#include <demo_runner.h>

void oopRun();
void line();

class PrintData {
public:
    void print(int i);

    void print(double f);

    void print(char c[]);
};


namespace learn {

    namespace demo {

        class OOP : virtual public demo_runner {
        public:
            void run() override;

            void name(std::string &name) override;
        };


    }

}

#endif //LEARN_CPP_OPP_H
