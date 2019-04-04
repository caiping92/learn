//
// Created by caiping on 2019/4/5.
//

#include "opp.h"
#include <iostream>

using namespace std;

void line() {
    cout << "==================" << endl;
}

void hello() {
    cout << "hello word" << endl;
}

void print() {
    PrintData pd;
    // 输出整数
    pd.print(5);
    // 输出浮点数
    pd.print(500.263);
    // 输出字符串
    char c[] = "Hello C++";
    pd.print(c);

}
class Box
{
public:

    double getVolume()
    {
        return length * breadth * height;
    }
    void setLength( double len )
    {
        length = len;
    }

    void setBreadth( double bre )
    {
        breadth = bre;
    }

    void setHeight( double hei )
    {
        height = hei;
    }
    // 重载 + 运算符，用于把两个 Box 对象相加
    Box operator+(const Box& b)
    {
        Box box;
        box.length = this->length + b.length;
        box.breadth = this->breadth + b.breadth;
        box.height = this->height + b.height;
        return box;
    }
private:
    double length;      // 长度
    double breadth;     // 宽度
    double height;      // 高度
};
void testOperation(){
    Box box1;                // 声明 box1，类型为 Box
    Box box2;                // 声明 box2，类型为 Box
    Box box3;                // 声明 box3，类型为 Box
    double volume = 0.0;     // 把体积存储在该变量中

    // box1 详述
    box1.setLength(6.0);
    box1.setBreadth(7.0);
    box1.setHeight(5.0);

    // box2 详述
    box2.setLength(12.0);
    box2.setBreadth(13.0);
    box2.setHeight(10.0);

    // box1 的体积
    volume = box1.getVolume();
    cout << "Volume of box1 : " << volume <<endl;

    // box2 的体积
    volume = box2.getVolume();
    cout << "Volume of box2 : " << volume <<endl;

    // 把两个对象相加，得到 box3
    box3 = box1 + box2;

    // box3 的体积
    volume = box3.getVolume();
    cout << "Volume of box3 : " << volume <<endl;
}

void oopRun() {
    hello();
    line();
    print();
    line();
    testOperation();

}





void PrintData::print(int i) {
    cout << "int: " << i << endl;
}

void PrintData::print(double f) {
    cout << "double: " << f << endl;
}

void PrintData::print(char *c) {
    cout << "char: " << *c << endl;
}
