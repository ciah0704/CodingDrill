/*
 * Copyright 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package coderstorm.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author ycoppel@google.com (Yohann Coppel)
 *
 * @param <T>
 *          Object's type in the tree.
 */
public class GenericTree<T> {

    private T value;

    private ArrayList<GenericTree<T>> leafs = new ArrayList<GenericTree<T>>();

    private GenericTree<T> parent = null;
    private GenericTree<T> root = null;

    private HashMap<T, GenericTree<T>> locate = new HashMap<T, GenericTree<T>>();


    public GenericTree(T value) {
        this.value = value;
        locate.put(value, this);
    }

    public void addLeaf(T parent, T leaf) {
        if (locate.containsKey(parent)) {
            locate.get(parent).addLeaf(leaf);
        } else {
            addLeaf(parent).addLeaf(leaf);
        }
    }

    public GenericTree<T> addLeaf(T leaf) {
        GenericTree<T> t = new GenericTree<T>(leaf);
        leafs.add(t);
        t.parent = this;
        t.root = (this.root==null) ? t : this.root;
        t.locate = this.locate;
        locate.put(leaf, t);
        return t;
    }

    public GenericTree<T> setAsParent(T parentRoot) {
        GenericTree<T> t = new GenericTree<T>(parentRoot);
        t.leafs.add(this);
        this.parent = t;
        t.locate = this.locate;
        t.locate.put(value, this);
        t.locate.put(parentRoot, t);
        return t;
    }

    public T getValue() {
        return value;
    }

    public GenericTree<T> getTree(T element) {
        return locate.get(element);
    }

    public GenericTree<T> getParent() {
        return parent;
    }

    public Collection<T> getSuccessors(T root) {
        Collection<T> successors = new ArrayList<T>();
        GenericTree<T> tree = getTree(root);
        if (null != tree) {
            for (GenericTree<T> leaf : tree.leafs) {
                successors.add(leaf.value);
            }
        }
        return successors;
    }

    public Collection<GenericTree<T>> getSubTrees() {
        return leafs;
    }

    public static <T> Collection<T> getSuccessors(T of, Collection<GenericTree<T>> in) {
        for (GenericTree<T> tree : in) {
            if (tree.locate.containsKey(of)) {
                return tree.getSuccessors(of);
            }
        }
        return new ArrayList<T>();
    }

    @Override
    public String toString() {
        return printTree(0);
    }

    private static final int indent = 2;

    private String printTree(int increment) {
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
            inc = inc + " ";
        }
        s = inc + value;
        for (GenericTree<T> child : leafs) {
            s += "\n" + child.printTree(increment + indent);
        }
        return s;
    }
}
