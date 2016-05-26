package hw9;


abstract class File {

    private String name;

    File(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return  name;
    }
}
