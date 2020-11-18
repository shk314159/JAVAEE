#include <bits/stdc++.h>
#define pb push_back
#define pss pair<int, string>
#define SZ(a) (int)a.size()
typedef long long ll;
using namespace std;
vector<int> symbol;//符号集
vector<int> end;
vector<string> path[26];
int judge(char ch) {
    //运算符进行优先级划分
    if(ch == '*') return 3;
    if(ch == '.') return 2;
    if(ch == '|') return 1;
    if(ch == '(') return 0;
    if(ch == ')') return 0;
}

string add(string s) {
	string res = "";
	for(int i = 0; i < s.length(); i++) {
		char now = s[i];
		char next;
		if (i == s.length() - 1) {
			next = '#';
		}
		else {
			next = s[i + 1];
		}
		if (((now != '(' && now != '.' && now != '|') || now == ')' || now == '*') 
			&& (next != ')'&& next != '*' &&next != '|' && next != '.' && next != '#')) {
			res = res + now + '.';
		}
		else {
			res = res + now;
		}
	}
	return res;
}
int main() {
	//	freopen("input.txt","r",stdin);
	//	freopen("output.txt","w",stdout);
	string str, Symbol_Set;
	cin >> Symbol_Set;
	for(int i = 0; i < Symbol_Set.length(); i++) {
		symbol.pb(Symbol_Set[i] - '0');
	}
	cin >> str;
	str = add(str);//删除. 
	cout << str << '\n';
	int slen = SZ(str);
    stack<char> mid; //字符串栈 ，用于中缀表达式转后缀表达式
    int i = 0;
    string s = "";
    while(i < slen) {
    	if(str[i] == '(') {//判断，左括号进栈
            mid.push(str[i]);
            i++;
        }
        else if(str[i] == ')') {//遇右括号则将左括号及左括号以上标识符出栈
            while(mid.top() != '(') {
                s = s + mid.top() ;
                mid.pop() ;
            }
            mid.pop() ;
            i++;
        }
     	else if(isdigit(str[i])) {//数字或小数点则直接转入后缀表达式
            s += str[i];
            i++;
        }
        else {
        	while (!mid.empty() && judge(mid.top()) >= judge(str[i])) {
				s = s + mid.top();
				mid.pop();
			}
			mid.push(str[i]);//将当前运算符进栈
            i++; 
		}
	}
	while(!mid.empty()) {//将最后剩余运算符出栈
        s = s + mid.top() ;
        mid.pop() ;
    }
    cout << s << '\n';
    int st = 0;
    
}

