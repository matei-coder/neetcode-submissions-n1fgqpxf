class MyHashSet {

private:
    int BUCKET_COUNT = 1000;
    vector<list<int>> buckets;

    int hash(int key){
        return key % BUCKET_COUNT;
    }
public:

    
    MyHashSet(): buckets(BUCKET_COUNT){}
    
    
    void add(int key) {
        int idx = hash(key);
        for (int x : buckets[idx]) {
            if (x == key) return;   
        }
        buckets[idx].push_back(key);
    }
    
    void remove(int key) {
        buckets[hash(key)].remove(key);
    }
    
    bool contains(int key) {
        for(int x  : buckets[hash(key)]){
            if(x == key)  return true;
        } return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */