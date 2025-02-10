import javax.management.remote.rmi.RMIConnectionImpl_Stub;
import java.util.ArrayList;

public class MyArrayList <E> {
    private int _size, capacity;
    private E[] array;

    public MyArrayList(){
        _size = 0;
        capacity = 5;
        array = (E[]) new Object[capacity];
    }
    public void add(E num) throws ArrayFullException{
        try{
            array[_size] = num;
            _size++;
        } catch(Exception _e){
            throw new ArrayFullException((Integer) num);
        }
    }
    public void addAt(E num, int pos) throws ArrayFullException {
        if(_size == capacity) throw new ArrayFullException((Integer) num);
        if(pos > _size+1 || pos < 1) throw new InvalidPositionException(_size);
        for(int i = _size; i >= pos; i--){
            array[i] = array[i-1];
        }
        _size++;
        array[pos-1] = num;
    }
    public boolean remove(E num){
        for(int i = 0; i < _size; i++){
            if(array[i] == num){
                _size--;
                for(int j = i; j < _size; j++){
                    array[j] = array[j+1];
                }
                return true;
            }
        }
        return false;
    }
    public E removeAt(int pos){
        if(pos > _size || pos < 1) throw new InvalidPositionException(_size);
        E deleted = (E) array[pos-1];
        _size--;
        for(int i = pos-1; i < _size; i++){
            array[i] = array[i+1];
        }
        return deleted;
    }
    public boolean contains(Integer num){
        for(int i = 0; i < _size; i++){
            if(num == array[i]){
                return true;
            }
        }
        return false;
    }
    public int size(){
        return _size;
    }
    public boolean isEmpty(){
        return _size == 0;
    }
    public E get(int pos){
        if(pos > _size || pos < 1) throw new InvalidPositionException(_size+1);
        return array[pos-1];
    }
    public E set(int pos, E num){
        if(pos > _size || pos < 1) throw new InvalidPositionException(_size+1);
        E repVal = (E) array[pos-1];
        array[pos-1] = num;
        return repVal;
    }
}
