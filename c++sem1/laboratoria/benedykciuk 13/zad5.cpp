#include <iostream>
using namespace std;

class Box {
private:
    double width, height, depth;
    class Ball {
    private:
        double r;
    public:
        Ball(double r) : r(r) {}
       bool fit(Box *box) {
            return r <= box->height / 2.0 &&
                    r <= box->width / 2.0 &&
                    r <= box->depth / 2.0;
        }
    };
    Ball *ball;
public:
    Box(double width, double height, double depth, double r) {
        this->width = width;
        this->height = height;
        this->depth = depth;
        ball = new Ball(r);
    }
    bool ball_fiting(Ball *b) { return b->fit(this); }
    Ball *get_ball() { return ball; }
};

int main() {
    Box *box = new Box(5.0, 6.0, 7.2, 2.5);
    cout << box->ball_fiting(box->get_ball()) << endl;
    return 0;
}
