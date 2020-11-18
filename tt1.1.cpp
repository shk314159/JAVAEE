#include <bits/stdc++.h>
#define pb push_back
#define pss pair<int, string>
#define SZ(a) (int)a.size()
typedef long long ll;
using namespace std;
vector<int> symbol;//���ż�
vector<int> end;
vector<string> path[26];
int judge(char ch) {
    //������������ȼ�����
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
	str = add(str);//ɾ��. 
	cout << str << '\n';
	int slen = SZ(str);
    stack<char> mid; //�ַ���ջ ��������׺���ʽת��׺���ʽ
    int i = 0;
    string s = "";
    while(i < slen) {
    	if(str[i] == '(') {//�жϣ������Ž�ջ
            mid.push(str[i]);
            i++;
        }
        else if(str[i] == ')') {//���������������ż����������ϱ�ʶ����ջ
            while(mid.top() != '(') {
                s = s + mid.top() ;
                mid.pop() ;
            }
            mid.pop() ;
            i++;
        }
     	else if(isdigit(str[i])) {//���ֻ�С������ֱ��ת���׺���ʽ
            s += str[i];
            i++;
        }
        else {
        	while (!mid.empty() && judge(mid.top()) >= judge(str[i])) {
				s = s + mid.top();
				mid.pop();
			}
			mid.push(str[i]);//����ǰ�������ջ
            i++; 
		}
	}
	while(!mid.empty()) {//�����ʣ���������ջ
        s = s + mid.top() ;
        mid.pop() ;
    }
    cout << s << '\n';
    int st = 0;
    
}

