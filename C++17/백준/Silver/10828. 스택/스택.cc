#include <iostream>
#include <stack>

using namespace std;

int main(void)
{
	stack<int> st;
	int n;
	string cmd;
	int temp;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> cmd;
		
		if (cmd == "push")
		{
			cin >> temp;
			st.push(temp);
		}
		else if (cmd == "pop")
		{
			if (st.empty())
			{
				cout << "-1" << endl;
			}
			else
			{
				cout << st.top();
				st.pop();
				cout << endl;
			}
		}
		else if (cmd == "empty")
		{
			cout << st.empty() << endl;
		}
		else if (cmd == "size")
		{
			cout << st.size() << endl;
		}
		else if (cmd == "top")
		{
			if (!st.empty())
				cout << st.top() << endl;
			else
				cout << "-1" << endl;
		}
	}

	return 0;
}