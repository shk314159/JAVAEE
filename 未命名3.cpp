#include <bits/stdc++.h>
#define pb push_back
#define pic pair<int, char>
#define SZ(a) (int)a.size()
typedef long long ll;
using namespace std;
vector<int> symbol;//符号集
vector<int> start;
vector<int> End;
vector<pic> path[26];
int judge(char ch) {
    //运算符进行优先级划分
    if(ch == '*') return 3;
    if(ch == '.') return 2;
    if(ch == '|') return 1;
    if(ch == '(') return 0;
    if(ch == ')') return 0;
}
struct point {
	char st;
	char ed;
};
int in[26];
int out[26];
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
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
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
    stack<point> stk;
	for(i = 0; i < s.length(); i++) {
		if(isdigit(s[i]))	{
			point tp;
			tp.st = 'A' + (st++);
			tp.ed = 'A' + (st++);
			path[tp.st - 'A'].pb({tp.ed - 'A', s[i]});
			stk.push(tp);
		}
		else if(s[i] == '.') {
			point b = stk.top(); stk.pop();
			point a = stk.top(); stk.pop();
			path[a.ed - 'A'].pb({b.st - 'A', '#'});
			a.ed = b.ed;
			stk.push(a);
		}
		else if(s[i] == '*') {
			point a = stk.top(); stk.pop();
			path[a.ed - 'A'].pb({a.st - 'A', '#'});
			char t1 = 'A' + st++;
			char t2 = 'A' + st++;
			point tp; 
			tp.st = t1, tp.ed = t2;
			path[t1 - 'A'].pb({a.st - 'A', '#'});
			path[t1 - 'A'].pb({t2 - 'A', '#'});
			path[a.ed - 'A'].pb({t2 - 'A', '#'});
			stk.push(tp);
		}
		else if(s[i] == '|') {
			point b = stk.top(); stk.pop();
			point a = stk.top(); stk.pop();
			char t1 = 'A' + st++;
			char t2 = 'A' + st++;
			point tp; 
			tp.st = t1, tp.ed = t2;
			path[t1 - 'A'].pb({a.st - 'A', '#'});
			path[t1 - 'A'].pb({b.st - 'A', '#'});
			path[a.ed - 'A'].pb({t2 - 'A', '#'});
			path[b.ed - 'A'].pb({t2 - 'A', '#'});
			stk.push(tp);
		}
	}
	memset(in, 0, sizeof(in));
	for(int i = 0; i < st; i++) {
		if(path[i].empty()) {
			End.pb(i);
			continue;
		}
		for(auto x : path[i]) {
			in[x.first]++;
		}
	}
	for(int i = 0; i < st; i++) {
		if(!in[i]) {
			start.pb(i);
		}
	}
	sort(start.begin(), start.end());
	sort(End.begin(), End.end());
	cout << "状态集：";
	for(int i = 0; i < st; i++) {
		printf("%c", 'A' + i); 
	}
	cout << '\n';
	cout << "符号集: "; 
	for(auto x : symbol) {
		cout << x;
	}
	cout << '\n';
	cout << "初态集： ";
	for(auto x : start) {
		printf("%c", x + 'A');
	}
	cout << '\n';
	cout << "终态集： ";
	for(auto x : End) {
		printf("%c", x + 'A');
	}
	cout << '\n';
	cout << "转移函数(其中用#表示epsilon): ";
	for(int i = 0; i < st; i++) {
		for(auto x : path[i]) {
			printf("(%c, %c, %c)", 'A' + i, x.second, 'A' + x.first); 
		}
	}
	cout << '\n';
	fclose(stdin);
	fclose(stdout);
}

