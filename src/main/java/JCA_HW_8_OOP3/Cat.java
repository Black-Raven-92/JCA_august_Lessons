package JCA_HW_8_OOP3;

public class Cat implements Mooving {
    private final int JUMP = 10;
    private final int RUN = 15;
    private String name;
    private String type;

    public Cat(String type, String name) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void move(Barrier [] barriers ){
        for(int i=0;i< barriers.length;i++){
            if(barriers[i] instanceof Wall){
                if (!jump(barriers[i])) {
                    System.out.printf("Кот по имени %s не перепрыгнул  стену и выбывает из марафона\n",this.name);
                    break;
                }

            }else if(barriers[i] instanceof Track){
                if(!run(barriers[i])){
                    System.out.printf("Кот по имени %s не пробежал трэк и выбывает из марафона\n",this.name);
                    break;
                }
            }
        }
    }

    @Override
    public boolean run(Barrier barriers) {

        if (this.RUN >= ((Track) barriers).getLengthTrack()) {
            System.out.printf("Кот пробежал трэк %s метров\n", ((Track) barriers).getLengthTrack());
            return true;
        }
        else return false;

    }
    @Override
    public boolean jump(Barrier barriers) {

        if (this.JUMP >= ((Wall) barriers).getHeight()) {
            System.out.printf("Кот перепрыгнул стену %s метров\n", ((Wall) barriers).getHeight());
            return true;
        }
        else return false;
    }



}
