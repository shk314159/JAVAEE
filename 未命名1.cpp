#include <bits/stdc++.h>
#define pb push_back
#define pss pair<int, string>
#define sz(a) (int)a.size()
typedef long long ll;
using namespace std;
vector<int> symbol;//符号集
vector<char> sb_st;// 初态集
vector<char> sb_ed;// 终态集
vector<char> state;//状态集
queue<pss > path[26];// 转移
int len;
int d;
int vis[26];
int main() {
//	freopen("input.txt","r",stdin);
//	freopen("output.txt","w",stdout);
	string Symbol_Set, form;
	cin >> Symbol_Set;
	for(int i = 0; i < Symbol_Set.length(); i++) {
		symbol.pb(Symbol_Set[i] - '0');
	}
	cin >> form;
	int flen = sz(form);
	int gt = 0;
	if(form[0] == '(') {
		int st = 1;
		int pass = 1;
		string add = "";
		for(int i = 1; i < flen; i++) {
			if(form[i] == '(') {
				st++;
			}
			else if(form[i] == ')') {
				st--;
                if(st == 0) {
                    pass = i;
                    break;
                }
			}
			add += form[i];
		}
		if(pass == flen - 2) {
			if(form[flen - 1] == '*') {
				path[0].push({0, add});
				gt = 1;
				sb_st.pb('A' + 0);
				sb_ed.pb('A' + 0);
			}
			else if(form[flen - 1] == '+') {
				path[0].push({1, add});
				path[1].push({1, add});
				gt = 2;
				sb_st.pb('A' + 0);
				sb_ed.pb('A' + 1);
			}
			else {
				path[0].push({1, form});
				gt = 2;
				sb_st.pb('A' + 0);
				sb_ed.pb('A' + 1);
			}
		}
		else {
			path[0].push({1, form});
			gt = 2;
			sb_st.pb('A' + 0);
			sb_ed.pb('A' + 1);
		}
	}
	else {
		path[0].push({1, form});
		gt = 2;
		sb_st.pb('A' + 0);
		sb_ed.pb('A' + 1);
	}
	while(1) {
		int f = 1;
		for(int i = 0; i < 26; i++) {
			if(path[i].empty()) continue;
			vector<pss> t;
			while(!path[i].empty()) {
				t.pb(path[i].front());
				path[i].pop();
			}
			for(auto x : t) {
				string s = x.second;
				string add = "";
				int st = i, ed = x.first;
				if(sz(s) == 1) {
					path[i].push(x);
				}
				else if(sz(s) != 1) {
					for(int j = 0; j < sz(s); j++) {
						if('0' <= s[j] && s[j] <= '9') {
							add += s[j];
							if(j == sz(s) - 1 || s[j + 1] == '|') {
								path[st].push({ed, add});
                                st = i;
                                j = j + 1;
							}
							else if(('0' <= s[j + 1] && s[j + 1] <= '9') || s[j + 1] == '(') {
								path[st].push({gt++, add});
								st = gt - 1;
							}
							else if(s[j + 1] == '*') {
//								if(j + 1 == sz(s) - 1) {
//                                    path[st].push({ed, add});
//								}
							    path[st].push({st, add});
								j = j + 1;
							}
							else if(s[j + 1] == '+') {
								path[st].push({gt++, add});
								st = gt - 1;
								path[st].push({st, add});
								j = j + 1;
							}
							add = "";
						}
						else if(s[j] == '(') {
							f = 0;
							int k = j + 1;
							int knum = 1;
							while(1) {
								if(s[k] == '(') {
									knum++;
								}
								else if(s[k] == ')') {
									knum--;
									if(!knum) {
										break;
									}
								}
								add += s[k++];
							}
							j = k;
							if(j == sz(s) - 1 || s[j + 1] == '|') {
								path[st].push({ed, add});
                                st = i;
                                j = j + 1;
							}
							else if(('0' <= s[j + 1] && s[j + 1] <= '9') || s[j + 1] == '(') {
								path[st].push({gt++, add});
								st = gt - 1;
							}
							else if(s[j + 1] == '*') {
								path[st].push({st, add});
								j = j + 1;
							}
							else if(s[j + 1] == '+') {
								path[st].push({gt++, add});
								st = gt - 1;
								path[st].push({st, add});
								j = j + 1;
							}
							add = "";
						}
					}
				}
			}
		}

		if(f == 1) break;
	}
	for(int i = 0; i < gt; i++) {
		state.pb('A' + i);
	}
	for(auto x : state) {
		cout << x;
	}
	cout << '\n';
	for(auto x : symbol) {
		cout << x;
	}
	cout << '\n';
	for(auto x : sb_st) {
		cout << x;
	}
	cout << '\n';
	for(auto x : sb_ed) {
		cout << x;
	}
	cout << '\n';
	for(int i = 0; i < 26; i++) {
		if(path[i].empty()) continue;
		while(!path[i].empty()) {
            pss x = path[i].front(); path[i].pop();
            cout << "(" << (char)(i + 'A') << ", " << x.second << ", " << (char)(x.first + 'A') << ")" << ' ';
		}
	}
	cout << '\n';
}
//现存问题
/*
1、无法寻找最后的ed值

2、开始的终止状态无法确定 
*/ 
