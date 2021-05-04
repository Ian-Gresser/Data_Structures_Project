/* Course: CS2852-011
 * fall 2020
 * Lab 7: Morse Encoder with a BST Map
 * Name: Ian Gresser
 * Created: 10-22-20
 */
package msoe.cs2852.lab07;

/**
 * Class that acts as a node in the map tree
 */
public class TreeMapNode {
    protected char key;
    protected String value = "";
    protected TreeMapNode leftChild = null;
    protected TreeMapNode rightChild = null;


    /**
     * instantiates the node values
     * @param key
     * @param value
     */
    public TreeMapNode(char key, String value){
        this.key = key;
        this.value = value;
    }


}
