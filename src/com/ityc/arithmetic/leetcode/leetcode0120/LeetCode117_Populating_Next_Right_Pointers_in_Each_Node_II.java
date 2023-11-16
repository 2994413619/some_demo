package com.ityc.arithmetic.leetcode.leetcode0120;

import com.ityc.arithmetic.leetcode.pojo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针 II ac:100%
 * @author yuchao
 * @Date 2023/11/17 00:09
 **/
public class LeetCode117_Populating_Next_Right_Pointers_in_Each_Node_II {

    public Node connect(Node root) {
        List<Node> nodes = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                nodes.add(root.left);
            }
            if (root.right != null) {
                nodes.add(root.right);
            }
        }

        while (nodes.size() != 0) {
            List<Node> temp = new ArrayList<>();
            for(int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).left != null) {
                    temp.add(nodes.get(i).left);
                }
                if (nodes.get(i).right != null) {
                    temp.add(nodes.get(i).right);
                }
                if (i < nodes.size() - 1) {
                    nodes.get(i).next = nodes.get(i + 1);
                }
            }
            nodes.clear();
            nodes = temp;
        }
        return root;
    }

}
