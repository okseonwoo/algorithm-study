#include <iostream>
#include <algorithm>
#include <map>
#include <vector>
#include <cmath>


using namespace std;

int N;
void Intput()
{
	cin >> N;
}

int mod(int S) {
    if (S < 0) {
        return -1;
    }

    if (S == 0) {
        return 0;
    }
    if (S >= 5) {
        int count_with_5 = mod(S - 5);
        if (count_with_5 != -1) {
            return count_with_5 + 1;
        }
    }

    if (S >= 3) {
        int count_with_3 = mod(S - 3);
        if (count_with_3 != -1) {
            return count_with_3 + 1;
        }
    }
    return -1;
}

void Solution()
{
	cout << mod(N);
}

void Solved() {
	Intput();
	Solution();
}

int main() {
	Solved();
}