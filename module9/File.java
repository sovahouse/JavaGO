package task1;


public abstract class File {

    private String name;

    public File(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return  name;
    }
}
