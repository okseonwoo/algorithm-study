#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main(void)
{
	int n;
	int n1 = 0;
	stack<char> st;
	string temp;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		n1 = 0;
		cin >> temp;

		for (int j = 0; j < temp.length(); j++)
		{
			if (temp[j] == '(')
				st.push(temp[j]);
			else if (temp[j] == ')')
			{
				if (st.empty())
				{
					cout << "NO" << endl;
					n1 = 1;
					break;
				}
				else
				{
					st.pop();
				}
			}
		}
		if (n1 == 1)
			continue;

		if (st.empty())
			cout << "YES" << endl;
		else
			cout << "NO" << endl;

		while (!st.empty())
			st.pop();
	}

	return 0;
}