#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#include<unordered_map>
using namespace std;
int N, M;
unordered_map<int, int> m;
vector<int> answer;
int main()
{
    cin >> N;
    for (int i = 0; i < N; i++) { 
        int num;
        cin >> num;
        m[num]++;
    }
 
    cin >> M;
    for (int i = 0; i < M; i++) {
        int value;
        cin >> value;
 
        if (m[value]) { 
            answer.push_back(1);
        }
        else {
            answer.push_back(0);
        }
    }
    for (auto i : answer)
        cout << i << "\n";
}
