
public class Runner {

    public static void main(String[] args) {

        UnixPath unixPath = new UnixPath();

        System.out.println(unixPath.simplify("/home/../var/./lib//file.txt"));
        System.out.println();
    }

}
