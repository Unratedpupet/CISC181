import java.util.Random;

public class PracticeSet3 {
    public static void main(String[] args) {
        // Put your code for Part C inside this main method
        int[] randomHeights = new int[10];
        String[] randomNames = new String[] {
                "Aggie", "Leia", "Luke", "Shoopy", "Lydia",
                "Dana", "Munchkin", "Igor", "Pinky", "Bobby"
        };
        int birdNameCounter = 0;
        int randomHeightsCounter = 0;

        Bird[][] flock = new Bird[3][3];


        Tree treeOne = new Tree(30, new Bird("Stella"));
        System.out.println(treeOne.getTreeBird().getName());
        treeOne.getTreeBird().setName("Marcus");
        System.out.println(treeOne.getTreeBird().getName());
        Tree[][] grove = new Tree[3][3];

        Random rand = new Random();
        for (int i = 0; i < randomHeights.length; i++) {
            randomHeights[i] = rand.nextInt(100);
        }

        for (int i = 0; i < grove.length; i++) {
            for (int j = 0; j < grove[i].length; j++) {
                grove[i][j] = new Tree(randomHeights[randomHeightsCounter], new Bird(randomNames[birdNameCounter]));
                birdNameCounter++;
                randomHeightsCounter++;
            }
        }

        for (Tree[] trees : grove) {
            for (Tree tree : trees) {
                System.out.println(tree.getTreeBird().getName());
                System.out.println(tree.getHeight());
            }
        }

        for (int i = 0; i < flock.length; i++) {
            for (int j = 0; j < flock[i].length; j++) {
                flock[i][j] = grove[i][j].getTreeBird();
                grove[i][j].setBird(null);
            }
        }

        System.out.println("Birds in flock");
        for (Bird[] birds : flock) {
            for (Bird bird : birds) {
                System.out.println(bird.getName());
            }
        }

        System.out.println("Checking grove birds");
        for (Tree[] trees : grove) {
            for (Tree tree : trees) {
                System.out.println(tree.getTreeBird());
            }
        }

        // Do not modify this class otherwise
    }
}

// Define your classes below
// Remember they cannot be public.
class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}

class Tree{

    private int height;
    private Bird treeBird;

    public Tree(int height, Bird treeBird) {
        this.height = height;
        this.treeBird = treeBird;
    }

    public int getHeight() { return this.height; }
    public Bird getTreeBird() { return this.treeBird; }
    public void setHeight(int height) { this.height = height; }
    public void setBird(Bird treeBird) { this.treeBird = treeBird; }

    public void swapBirds(Tree oldBird, Tree newBird) {
        Bird tempBird = oldBird.treeBird;
        oldBird.treeBird = newBird.getTreeBird();
        newBird.treeBird = tempBird;

    }
}