//
// Created by ccc25 on 2019/11/10.
//

#ifndef LEARN_CPP_DEMO_DATA_TYPE_H
#define LEARN_CPP_DEMO_DATA_TYPE_H

#include <demo_runner.h>

namespace learn {

    namespace demo {


        class demo_data_type : virtual public demo::demo_runner{
        public:
            void run() override;

            void name(std::string &name) override;
        };

    }

}


#endif //LEARN_CPP_DEMO_DATA_TYPE_H
