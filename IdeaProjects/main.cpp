#include <bits/stdc++.h>
typedef long long ll;
using namespace std;
int i = 0;
map<map<int, string>, int> go;
map<int, map<string, vector<string> > > C;
map<string, vector<string> > G;
vector<string> Gc;
map<string, vector<string> > Gitems;
map< map<int, string>, string> action;
map< map<int, string>, string> GOTO;
string s[30];
int n, Gnum;
void input() {
    int f = 0;
    int i = 1;
    n = 1;
    while(cin >> s[i]) {
//        int pos = s.find_first_of("->");
//        string dt = s.substr(0, s.find_first_of("->"));
//        string nx = s.substr(pos + 2)
//        cout << dt << " " << nx << '\n';
//        G[dt].push_back(nx);
        if(i == 1) {
            s[0] = "Z->" + s[1][1];
        }
        n++;
    }
}
struct DFA{
    int id;
    int last[30];
    int fa;
    string s[30];
    int ct;
    int pos;
}LR0[30];
void addPoint(int id, int line) {
    string tp = "";
    tp = LR0[id].s[line].substr(0, 3);
    tp += '.';
    tp += LR0[id].s[line].substr(3);
    LR0[id].s[line] = tp;
}
void addG(int id, char st) {
    for(int i = 0; i < n; i++) {
        if(s[i][0] == st) {
            LR0[id].s[LR0[id].ct] = s[i];
            addPoint(id, LR0[id].ct);
            LR0[id].ct++;
        }
    }

}
void move_Right(int id, int line) {
    int x = LR0[id].s[line].find_first_of(".");
    LR0[id].last[line] = Gnum;
    LR0[id].fa = id;
    LR0[Gnum].ct++;
    swap(LR0[Gnum].s[0][x], LR0[Gnum].s[0][x + 1]);
    LR0[Gnum].pos = x + 1;
}
void remove(int id) {
    for(int i = 0; i < id; i++) {
        for(int j = i + 1; j <= id; j++) {
            if(LR0[i].s[0] == LR0[j].s[0]) {
                int k = LR0[j].fa;
                for(int l = 0; l < LR0[k].ct; l++) {
                    if(LR0[k].last[l] == j) {
                        LR0[k].last[l] = i;
                    }
                }
                LR0[j].ct = 0;
            }
        }
    }
}
void solve() {
    Gnum = 0;
    for(int i = 0; i < 30; i++) {
        LR0[i].id = i;
        if(i == 0) {
            LR0[0].s[0] = s[0];
            addPoint(i, LR0[i].ct);
            LR0[i].ct++;
            LR0[i].pos = 3;
            if(LR0[i].s[0][4] >= 'A' && LR0[i].s[0][4] < 'Z') {
                addG(i, LR0[i].s[0][4]);
            }
            Gnum++;
            for(int j = 0; j < LR0[0].ct; j++) {
                if(LR0[i].s[j][LR0[i].s[j].length() - 1] != '.') {
                    move_Right(i, j);
                    Gnum++;
                }
            }
        }
        else {
            int len = LR0[i].s[0].length();
            if(LR0[i].ct == 1 && LR0[i].s[0][len - 1] == '.') {
                continue;
            }
            else {
                int pos = LR0[i].pos;
                if(LR0[i].s[0][pos + 1] >= 'A' && LR0[i].s[0][pos + 1] < 'Z') {
                    addG(i, LR0[i].s[0][pos + 1]);
                }
                for(int j = 0; j < LR0[i].ct; j++) {
                    move_Right(i, j);
                    Gnum++;
                }
                remove(i);
            }
        }
    }
    for(int i = 0; i < 30; i++) {
        for(int j = i + 1; j < 30; j++) {
            if(LR0[i].ct == 0 && LR0[j].ct != 0 && LR0[i].id < LR0[j].id) {
                int k = LR0[j].fa;
                for(int l = 0; l < LR0[k].ct; l++) {
                    if(LR0[k].last[l] == j) {
                        LR0[k].last[l] = i;
                    }
                }
                LR0[i] = LR0[j];
                LR0[j].ct = 0;
            }
        }
    }
    Gnum = 0;
    while(LR0[Gnum].ct != 0) {
        Gnum++;
    }
    //debug
//    for(int i = 0; i < Gnum; i++) {
//        cout << i << ": " << '\n';
//        for(int j = 0; j < LR0[i].ct; j++) {
//            cout << LR0[i].s[j] << '\n';
//        }
//
//    }

}
string r[30];
int r_index[30][30];
void get(int id, int line) {
    string tp = LR0[id].s[line];
    if(LR0[id].ct == 1 && line == 0 && tp.length() - 1 == LR0[id].pos) {
        if(LR0[id].s[line][0] == 'Z') {
            r[id + 1] = "acc";
        }
        else {
            r[id + 1] = "";
            for(int i = 0; i < 30; i++) {
                r[id + 1] += 'r';
            }
        }

    }
    else {
        char nx;
        if(line == 0) {
            nx = LR0[id].s[line][LR0[id].pos + 1];
        }
        else {
            nx = LR0[id].s[line][4];
        }
        for(int i = 0; i < r[0].length(); i++) {
            if(r[0][i] == nx) {
                r_index[id + 1][i] = LR0[id].last[line];
            }
        }
    }
}
void match() {
    for(int i = 0; i < Gnum; i++) {
        for(int j = 0; j < LR0[i].ct; j++) {
            get(i, j);
        }
    }

}

void output() {
    r[0] = "";

    for(int i = 0; i <= Gnum; i++) {
        if(i == 0) {
            cout << "   ";
        }
        else
    }

}

int main() {
    input();
    solve();
    match();
    output();
}
/*
 #include<iostream>
#include<iomanip>
#include<string.h>
using namespace std;

char str[10][10];//存储文法
int n;//存储文法行数
int v=0;//存储生成项的个数
char r[20][10];//存储分析表的float�?
int rr[20][10];//存储分析表的int�?
struct DFA{
	int num;//记录生成项的序号
	int  c[10];//存储该项的上丢�项位�?
	int f;//记录
	char ss[10][10];//存储该项的文�?
	int count;//记录该项的文法行�?
	int l;//存储第一行字符串'.'的位�?
}LR[20];

//初始化，输入上下文无关文法，�?号结�?
void Init(){
	int i,j;
	cout<<"输入上下文无关文法："<<endl;
	for(i=1;;i++){
		cin>>str[i];
		if(str[i][0]=='#')
		break;
	}
	strcat(str[0],"Z->");
	str[0][3]=str[1][0];
	n=i+1;
}

//在一弢�始编程时可先给定文法，避免每次测试重复输�?
void input(){
	int i,j;
	strcat(str[0],"Z->E");
	strcat(str[1],"E->aA");
	strcat(str[2],"E->bB");
	strcat(str[3],"A->cA");
	strcat(str[4],"A->d");
	strcat(str[5],"B->cB");
	strcat(str[6],"B->d");
	n=7;
	for(i=0;i<n;i++)
	cout<<str[i]<<endl;
	cout<<"***************************"<<endl;
}

//为文法添加小数点
void AddD(int a,int b){//为LR[a]的ss第b行字符串添加'.'
	int i,j=0;
	char c[10];
	for(i=0;i<3;i++)
	c[j++]=LR[a].ss[b][i];
	c[3]='.';
	j++;
	for(i=3;i<strlen(LR[a].ss[b]);i++)
	c[j++]=LR[a].ss[b][i];
	memset(LR[a].ss[b],0,sizeof(LR[a].ss[b]));
	for(i=0;i<j;i++)
	LR[a].ss[b][i]=c[i];
}

//添加移进项目的文�?
void AddG(int a,char s){//把str文法中左部非终结符与s相同的文法，添加进LR[a]�?
	int i,j,k;
	for(i=0;i<n;i++){
		if(str[i][0]==s){
			for(j=0;j<strlen(str[i]);j++)
			LR[a].ss[LR[a].count][j]=str[i][j];
			AddD(a,LR[a].count);
			LR[a].count++;
		}
	}
}

//将文法小圆点向后移一�?
void add(int a,int j){
	int i,k;
	char temp;
	for(i=0;i<strlen(LR[a].ss[j]);i++){
		LR[v].ss[0][i]=LR[a].ss[j][i];
		if(LR[a].ss[j][i]=='.')
		k=i;//记录小圆点的位置
	}
	LR[a].c[j]=v;//记录该条文法的跳转（子）项数
	LR[v].f=a;//记录跳转项数的来源（父代�?
	LR[v].count++;
	temp=LR[v].ss[0][k+1];//小圆点向后移丢��?
	LR[v].ss[0][k+1]=LR[v].ss[0][k];
	LR[v].ss[0][k]=temp;
	LR[v].l=k+1;//记录小圆点的位置
}

//更新某一项的来源（父代）和每丢�句文法的跳转项（子代�?
void fix(int a,int b){
	int i,j,k;
	k=LR[b].f;//父代
	for(i=0;i<LR[k].count;i++)
	if(LR[k].c[i]==b)
	LR[k].c[i]=a;//子代
}

//比较，删除相同的内容
void Compare(int a){
	int i,j,k;
	for(i=0;i<a;i++){
		for(j=i+1;j<=a;j++){
			if(strcmp(LR[i].ss[0],LR[j].ss[0])==0){//若相�?
				fix(i,j);
				memset(LR[j].ss,0,sizeof(LR[j].ss));//靠后的文法内容清�?
				LR[j].count=0;
			}
		}
	}
}

//LR(0)规范集的构建
void gfj(){
	int i,j,k,p;
	for(i=0;i<20;i++){
		LR[i].num=i;//Ii
		if(i==0){//第一个，赋予文法的初始符Z->E
			for(k=0;k<strlen(str[0]);k++)
			LR[0].ss[0][k]=str[0][k];
			AddD(0,LR[0].count);//添加小圆�?Z->.E
			LR[0].l=3;//小圆点的位置
			LR[0].count++;//文法数目+1
	    	if(LR[i].ss[0][4]>='A'&&LR[i].ss[0][4]<'Z')
	    	AddG(i,LR[i].ss[0][4]);//添加移进项目的文法E->aA E->bB
	    	v++;
            //为每丢�个文法进行向外扩�?I1、I2、I3
	    	for(j=0;j<LR[0].count;j++){
	    		p=strlen(LR[0].ss[j]);
		    	if(LR[0].ss[j][p-1]!='.'){
		    		add(0,j);//将向外扩散的文法小圆点向后移丢��?
		    		v++;
		    	}
	    	}
		}
    	else{//除I0以外的生成项
    		p=strlen(LR[i].ss[0]);//Ii第一句文法的长度
    		if(LR[i].count==1&&LR[i].ss[0][p-1]=='.'){//若小圆点再最后则不进行处�?
    	    }
    		else{
	        	p=LR[i].l;//小圆点的位置
	        	if(LR[i].ss[0][p+1]>='A'&&LR[i].ss[0][p+1]<'Z')
	        	AddG(i,LR[i].ss[0][p+1]);//添加移进项目的文�?
	            //为每丢�个文法进行向外扩�?
	        	for(j=0;j<LR[i].count;j++){
	        		add(i,j);//将待向外扩散的文法小圆点向后移一�?
	        		v++;
	            }

	        }
            Compare(i);//对所有已生成的项进行比较，若有重复的则删除i值靠后的
		}
	}
    //将生成的项进行整理，补齐有缺的部分（删除重复的之后可能会有内容为空，从后面补齐）
    for(i=0;i<20;i++){
    	for(j=i+1;j<20;j++){
    		if(LR[i].count==0&&LR[j].count!=0&&LR[i].num<LR[j].num){
    			fix(i,j);
    			LR[i]=LR[j];
    			LR[j].count=0;
			}
		}
	}
	//对当前的生成项进行编�?
	for(i=0;LR[i].count!=0;)
	i++;
	v=i;
	//输出当前生成项及各项的文�?
	cout<<"各项的序号和文法内容�?<<endl;
	for(i=0;i<v;i++){
    	cout<<i<<":"<<endl;
    	for(j=0;j<LR[i].count;j++)
    	cout<<LR[i].ss[j]<<endl;
        cout<<endl;
    }
}


//分析表根据第丢�行进行匹配处�?
void match(int a,int b){
	int i,j;
	char k;
	if(b==0&&LR[a].count==1&&strlen(LR[a].ss[b])-1==LR[a].l){//若是终结文法 （即小圆点在朢�后）
		if(LR[a].ss[b][0]=='Z')//且是初始符终�?
    	strcpy(r[a+1],"acc");
    	else
		for(i=0;i<5;i++)//Action都输出r
		r[a+1][i]='r';
	}
    else{//不是终结文法，k储存小圆点后丢�个字符，进行比较判断
    	if(b==0)
    	k=LR[a].ss[b][LR[a].l+1];
    	else
    	k=LR[a].ss[b][4];
    	for(i=0;i<strlen(r[0]);i++){
    		if(r[0][i]==k)
    		rr[a+1][i]=LR[a].c[b];
    	}
	}
}

//进行分析表的构建和输�?
void Output(){
	int i,j,k,temp;
	strcpy(r[0],"abcd#EAB");//分析表的第一�?
	cout<<"LR0分析表："<<endl;
	cout<<setw(20)<<"Action"<<setw(18)<<"Goto"<<endl;
	//分析表根据第丢�行进行匹�?
    for(i=0;i<v;i++){
    	for(j=0;j<LR[i].count;j++)
    	match(i,j);//进行匹配处理
	}
	//进行分析表输出形式的处理
	for(i=0;i<v+1;i++){
		temp=0;
		//保证输出对其
		if(i==0)
		cout<<"   ";
        if(i>0&&i<=10)
    	cout<<" "<<i-1<<":";
    	if(i>10)
    	cout<<i-1<<":";
    	if(strcmp(r[i],"acc")==0)
    	cout<<setw(24);
    	//先输出Action部分
		for(j=0;j<5;j++){
		    if(r[i][j]=='r'){//输出终结文法
    	    	cout<<setw(4)<<r[i][j]<<k;
    	    	temp=1;
    	    }
    	    else if(strcmp(r[i],"acc")==0)//输出起始符的终结欸文�?
    	    cout<<r[i][j];
	    	else{
	    		if(i==0)
    	    	cout<<setw(5)<<r[i][j];
    	    	else if(rr[i][j]==0)
    	    	cout<<setw(5)<<" ";
    	    	else
    	    	cout<<setw(4)<<"S"<<rr[i][j];
    	    }
	    }
	    if(temp==1)
	    k++;//进行对r1、r2、r3等下标的处理
	    //再输出Goto部分
		for(j=5;j<strlen(r[0]);j++){
			if(i==0)
    	    cout<<setw(5)<<r[i][j];
    	    else if(rr[i][j]==0)
    	    cout<<setw(5)<<" ";
    	    else
    	    cout<<setw(5)<<rr[i][j];
		}
		cout<<endl;
	}
}

//主函�?
int main(){
	int i,j;
	Init();
	//input();//输入上下文无关文�?
	gfj();//规范集的构建
	//Excels();
    Output();//输出分析�?
}

 */