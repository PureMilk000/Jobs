#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
class HuiHua {
public:
    HuiHua()
    {
        cin >> N;
        while (N)
        {
            int id;
            cin >> id;
            v.push_back(id);
            N--;
        }
        reverse(v.begin(), v.end());
        for (auto it = v.begin(); it != v.end(); ++it)
        {
            if(find(v2.begin(),v2.end(),*it)==v2.end())
            {
                v2.push_back(*it);
            }
        }
    }
    void print()
    {
        for (auto it2 = v2.begin(); it2 != v2.end(); ++it2)
        {
            cout << *it2<<" ";
        }
        cout << endl;
    }
 
private:
    int N;
    vector<int> v;
    vector<int> v2;
};

int main() 
{
    int T;
	cin>>T;

    HuiHua* huihua = new HuiHua[T];
    for (int i = 0; i < T; ++i)
    {
        huihua[i].print();
    }
    return 0;
}