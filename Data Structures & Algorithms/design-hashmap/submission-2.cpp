class MyHashMap {
private: 
    int BUCKET_COUNT = 10000;
    vector<list<pair<int , int>>> buckets;

    int hash(int key){
        return key%BUCKET_COUNT;
    }



public:
    MyHashMap(): buckets(BUCKET_COUNT){}
    
    void put(int key, int value) {
        int idx = hash(key);
        for(auto &it : buckets[idx]){
            if(it.first == key) {
                it.second = value;
                return;
            }
        }
        buckets[idx].push_back({key , value});
    }
    
    int get(int key) {
        int idx = hash(key);
        for(auto &it : buckets[idx]){
            if(it.first== key) return it.second;
        }
        return -1;

    }
    
    void remove(int key) {
    int idx = hash(key);
    buckets[idx].remove_if([key](const pair<int,int>& p) {
        return p.first == key;
    });
}
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */