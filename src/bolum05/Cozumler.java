package bolum05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cozumler {
    
    // 4. Verilen bir ikili arama agacindaki sayilari buyukten kucuge ekrana yazan
    // fonksiyonu yaziniz.
    static void sirala(Tree tree) {
        tree.root.printPreOrder();
    }
    
    // 5. Verilen bir ikili arama agacindaki dolu dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun hem sol hem sag cocugu varsa o dugume dolu dugum denir
    static int doluDugumSayisi(Node root) {
        if (root.left != null && root.right != null) {
            return 1 + doluDugumSayisi(root.left) + doluDugumSayisi(root.right);
        } else
            return 0;
    }
    
    // 6. Verilen bir ikili arama agacindaki tek dugum sayisini hesaplayan fonksiyonu
    // yaziniz. Bir dugumun degeri tek sayiysa o dugume tek dugum denir.
    static int tekDugum(Node root) {
        if (root != null) {
            if (isOdd(root.data)) {
                return 1 + tekDugum(root.left) + tekDugum(root.right);
            } else
                return 0 + tekDugum(root.left) + tekDugum(root.right);
        } else
            return 0;
    }
    
    // 7. Verilen bir ikili arama agacindaki yapraklardan rastgele bir tanesini dondu-
    // ren bir fonksiyonu yaziniz.
    static Node rasgeleYaprak(Node root) {
        if (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            getPostOrder(list, root);
            
            Node[] array = new Node[list.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = new Node(list.get(i));
            }
            
            Random random = new Random();
            int r = random.nextInt(array.length);
            return array[r];
        }
        return null;
    }
    
    static int size(Node root) {
        return root != null ? (1 + size(root.left) + size(root.right)) : 0;
    }
    
    private static void getPostOrder(List<Integer> list, Node root) {
        if (root != null) {
            list.add(root.data);
            getPostOrder(list, root.left);
            getPostOrder(list, root.right);
        }
    }
    
    private static boolean isOdd(int n) {
        return n % 2 == 1;
    }
}
