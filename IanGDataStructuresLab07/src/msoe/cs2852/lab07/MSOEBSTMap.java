/* Course: CS2852-011
 * fall 2020
 * Lab 7: Morse Encoder with a BST Map
 * Name: Ian Gresser
 * Created: 10-22-20
 */
package msoe.cs2852.lab07;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * map class used by the MorseEncoder class that uses the TreeMapNode class nodes
 */
public class MSOEBSTMap implements Map<Character, String> {

    public TreeMapNode headNode;

    /**
     * constructor that sets headnode to null
     */
    public MSOEBSTMap(){
        headNode = null;
    }

    /**
     * containsKey iterates through the
     * @param key key in the map we are trying to find
     * @return boolean based off if map contains the key or not
     */
    @Override
    public boolean containsKey(Object key) {

        if(! (key instanceof Character)) {

            return false;
        }

        char c = (Character) key;
        TreeMapNode curr = headNode;

        while (curr != null){

            if (curr.key == c){
                return true;
            } else{
                if (c < curr.key){
                    curr = curr.leftChild;

                } else if (c > curr.key){
                    curr = curr.rightChild;

                }

            }

        }
        return false;
    }

    /**
     * find a key and get the value of the key
     * @param key key we want to find
     * @return the value of the key we wanted
     */
    @Override
    public String get(Object key) {
        if(! (key instanceof Character)) {
            return null;
        }
        Character c = (Character) key;

        TreeMapNode curr = headNode;
        TreeMapNode nextLeft = curr.leftChild;
        TreeMapNode nextRight = curr.rightChild;
        boolean searching = true;
        while (searching){
            if (curr.key == c){

                return curr.value;
            }else{
                if (c < curr.key){
                    curr = curr.leftChild;

                }else if (c > curr.key){
                    curr = curr.rightChild;

                }
                if (curr == null){
                    searching = false;
                }
            }
        }
        return null;
    }

    /**
     * puts a key and value in a map
     * @param key key of the value we are putting into the map
     * @param value value being added into the map
     * @return value we added
     */
    @Override
    public String put(Character key, String value){
        if (headNode == null){
            headNode = new TreeMapNode(key, value);
            return null;
        }
        TreeMapNode curr = headNode;
        TreeMapNode parent = null;
        boolean searching = true;
        while (searching){

            if (curr.key == key){
                String prevVal = curr.value;
                curr.value = value;
                return prevVal;

            }else{
                if (key < curr.key){
                    parent = curr;
                    curr = curr.leftChild;

                } else if (key > curr.key){
                    parent = curr;
                    curr = curr.rightChild;

                }
                if (curr == null){
                    searching = false;
                }
            }
        }
        TreeMapNode node = new TreeMapNode(key, value);
        if (parent.key > key){
            parent.leftChild = node;

        }
        if (parent.key < key){
            parent.rightChild = node;

        }
        return null;
    }



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }




    @Override
    public boolean containsValue(Object value) {
        return false;
    }





    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry<Character, String>> entrySet() {
        return null;
    }

    @Override
    public String getOrDefault(Object key, String defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super Character, ? super String> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super Character, ? super String, ? extends String> function) {

    }

    @Override
    public String putIfAbsent(Character key, String value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(Character key, String oldValue, String newValue) {
        return false;
    }

    @Override
    public String replace(Character key, String value) {
        return null;
    }

    @Override
    public String computeIfAbsent(Character key, Function<? super Character, ? extends String> mappingFunction) {
        return null;
    }

    @Override
    public String computeIfPresent(Character key, BiFunction<? super Character, ? super String, ? extends String> remappingFunction) {
        return null;
    }

    @Override
    public String compute(Character key, BiFunction<? super Character, ? super String, ? extends String> remappingFunction) {
        return null;
    }

    @Override
    public String merge(Character key, String value, BiFunction<? super String, ? super String, ? extends String> remappingFunction) {
        return null;
    }
}
