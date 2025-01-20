#include <iostream>
#include <deque>
using namespace std;
deque<pair<int,int>> dq;
int N;
int main(void)
{
	cin >> N;
	int num;
	for (int i = 0; i < N; i++)
	{
		cin >> num;
		dq.push_back(make_pair(num,i+1)); 
        }
	while (!dq.empty())
	{
		int cur = dq.front().first;
		cout << dq.front().second << " ";
		dq.pop_front();

		if (dq.empty()) 
			break;

		if (cur > 0)
		{ 
			for (int i = 0; i < cur-1; i++)
			{
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}
		else
		{
			for (int i = 0; i < (-1)*cur; i++)
			{ 
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}
	}

	return 0;
}
