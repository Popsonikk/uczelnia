#include <iostream>
#include <vector>

struct Node
{
    Node* ojciec;
    Node * lewy;
    Node* prawy;
    std::string key;
    std::vector<std::string> value;
};
Node *splay(Node *node)
{
    while (1)
    {

        Node *dad = node->ojciec;
        if (dad == nullptr)
            return node;

        Node *grandpa = dad->ojciec;
        if (grandpa == nullptr)
        {
            if (dad->lewy == node)
            {
                // Rotate right
                node->ojciec = nullptr;
                dad->ojciec = node;
                dad->lewy = node->prawy;
                if(dad->lewy!=nullptr)
                    dad->lewy->ojciec=dad;
                node->prawy = dad;
            }
            else // if(dad->prawy==node)
            {
                // Rotate left
                node->ojciec = nullptr;
                dad->ojciec = node;
                dad->prawy = node->lewy;
                if(dad->prawy!=nullptr)
                    dad->prawy->ojciec=dad;
                node->lewy = dad;
            }
        }
        else
        {
            if (grandpa->lewy == dad && dad->lewy == node)
            {
                // Zig-Zig (Left-Left)
                node->ojciec = grandpa->ojciec;
                grandpa->ojciec = dad;
                dad->ojciec = node;
                grandpa->lewy = dad->prawy;
                if(grandpa->lewy!=nullptr)
                    grandpa->lewy->ojciec=grandpa;
                dad->prawy = grandpa;
                dad->lewy = node->prawy;
                if(dad->lewy!=nullptr)
                    dad->lewy->ojciec=dad;
                node->prawy = dad;
            }
            else if (grandpa->lewy == dad && dad->prawy == node)
            {
                // Zig-Zag (Left-Right)
                node->ojciec = grandpa->ojciec;
                dad->ojciec = node;
                grandpa->ojciec = node;
                dad->prawy = node->lewy;
                if(dad->prawy!=nullptr)
                    dad->prawy->ojciec=dad;
                grandpa->lewy = node->prawy;
                if(grandpa->lewy!=nullptr)
                    grandpa->lewy->ojciec=grandpa;
                node->lewy = dad;
                node->prawy = grandpa;

            }
            else if (grandpa->prawy == dad && dad->prawy == node)
            {
                // Zag-Zag (Right-Right)
                node->ojciec = grandpa->ojciec;
                grandpa->ojciec = dad;
                dad->ojciec = node;
                grandpa->prawy = dad->lewy;
                if(grandpa->prawy!=nullptr)
                    grandpa->prawy->ojciec=grandpa;
                dad->lewy = grandpa;
                dad->prawy = node->lewy;
                if(dad->prawy!=nullptr)
                    dad->prawy->ojciec=dad;
                node->lewy = dad;
            }
            else // if(grandpa->prawy==dad && dad->lewy==node)
            {
                // Zag-Zig (Right-Left)
                node->ojciec = grandpa->ojciec;
                dad->ojciec = node;
                grandpa->ojciec = node;
                dad->lewy = node->prawy;
                if(dad->lewy!=nullptr)
                    dad->lewy->ojciec=dad;
                grandpa->prawy = node->lewy;
                if(grandpa->prawy!=nullptr)
                    grandpa->prawy->ojciec=grandpa;
                node->prawy = dad;
                node->lewy = grandpa;

            }
            if(node->ojciec!=nullptr)
            {
                if(node->ojciec->lewy==grandpa)
                    node->ojciec->lewy=node;
                else if(node->ojciec->prawy==grandpa)
                    node->ojciec->prawy=node;
            }
        }
    }
}

Node*  dodaj (Node * root,std::string key,std::string value)
{
    if(root==nullptr)
        return new Node{nullptr,nullptr,nullptr,key,{value}};
    Node *pom=root;
    while(1)
    {
        if(key < pom->key)
        {
            if(pom->lewy!=nullptr)
                pom=pom->lewy;
            else
            {
                Node *node=new Node{pom,nullptr,nullptr,key,{value}};
                pom->lewy=node;
                root=splay(node);

                return root;
            }
        }
        else if(key> pom->key)
        {
            if(pom->prawy!=nullptr)
                pom=pom->prawy;
            else
            {
                Node *node=new Node{pom,nullptr,nullptr,key,{value}};
                pom->prawy=node;
                root=splay(node);

                return root;
            }
        }
        else
        {
            pom->value.emplace_back(value);
            root=splay(pom);

            return root;
        }
    }
}
Node* pokaz(Node * root,std::string key)
{
    if(root==nullptr)
        return nullptr;
    Node *pom=root;
    while(1)
    {
        if(key < pom->key)
        {
            if(pom->lewy!=nullptr)
                pom=pom->lewy;
            else
                return root;
        }
        else if(key> pom->key)
        {
            if(pom->prawy!=nullptr)
                pom=pom->prawy;
            else
                return root;
        }
        else
        {
            for(std::vector<std::string>::iterator it=pom->value.begin();it!=pom->value.end();++it)
                std::cout<<*it<<' ';
            root=splay(pom);
            return root;
        }
    }
}
int main()
{
   std::ios_base::sync_with_stdio(false);
   int n;
   Node * imiona=nullptr;
   Node * nazwiska=nullptr;
   std::cin>>n;
   std::cin.ignore();
   std::string x;
   for(int i=0;i<n;i++)
   {
       std::getline(std::cin, x);
       if(x=="d")
       {
           std::string imie,nazwisko;
           std::getline(std::cin, imie);
           std::getline(std::cin, nazwisko);
           imiona= dodaj(imiona,imie,nazwisko);
           nazwiska=dodaj(nazwiska,nazwisko,imie);
       }
       else if(x=="i")
       {
           std::string imie;
           std::getline(std::cin, imie);
           imiona=pokaz(imiona,imie);
       }
       else if(x=="n")
       {
           std::string nazwisko;
           std::getline(std::cin, nazwisko);
           nazwiska=pokaz(nazwiska,nazwisko);
       }
   }
}
