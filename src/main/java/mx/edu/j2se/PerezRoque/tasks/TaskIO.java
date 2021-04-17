package mx.edu.j2se.PerezRoque.tasks;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;

/**
 * In this class are the methods to save and read the tasks.
 * here are different ways to save and read the tasks.
 */
public class TaskIO {

    /**
     * here, the tasks from list are written in the stream.
     * @param tasks the list of tasks to be written.
     * @param out the stream where the tasks will be written.
     * @throws IOException in case that something is wrong with the file.
     */
    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException{
        try{
            DataOutput o = new DataOutputStream(out);
            o.writeInt(tasks.size());
            tasks.getStream().forEach(element -> {
                try{
                    o.writeInt(element.getTitle().length());
                    o.writeChars(element.getTitle());
                    o.writeBoolean(element.isActive());
                    o.writeBoolean(element.isRepeated());
                    if(element.isRepeated()){
                        o.writeInt(element.getRepeatInterval().getYear());
                        o.writeInt(element.getRepeatInterval().getMonthValue());
                        o.writeInt(element.getRepeatInterval().getDayOfMonth());
                        o.writeInt(element.getRepeatInterval().getHour());
                        o.writeInt(element.getRepeatInterval().getMinute());
                        o.writeInt(element.getRepeatInterval().getSecond());
                        o.writeInt(element.getRepeatInterval().getNano());

                        o.writeInt(element.getStartTime().getYear());
                        o.writeInt(element.getStartTime().getMonthValue());
                        o.writeInt(element.getStartTime().getDayOfMonth());
                        o.writeInt(element.getStartTime().getHour());
                        o.writeInt(element.getStartTime().getMinute());
                        o.writeInt(element.getStartTime().getSecond());
                        o.writeInt(element.getStartTime().getNano());

                        o.writeInt(element.getEndTime().getYear());
                        o.writeInt(element.getEndTime().getMonthValue());
                        o.writeInt(element.getEndTime().getDayOfMonth());
                        o.writeInt(element.getEndTime().getHour());
                        o.writeInt(element.getEndTime().getMinute());
                        o.writeInt(element.getEndTime().getSecond());
                        o.writeInt(element.getEndTime().getNano());
                    }else{
                        o.writeInt(element.getTime().getYear());
                        o.writeInt(element.getTime().getMonthValue());
                        o.writeInt(element.getTime().getDayOfMonth());
                        o.writeInt(element.getTime().getHour());
                        o.writeInt(element.getTime().getMinute());
                        o.writeInt(element.getTime().getSecond());
                        o.writeInt(element.getTime().getNano());
                    }
                }catch (IOException e){

                }
            });

        }catch ( IOException e){

        }
        out.close();
    }

    /**
     * reads the asks from the list and add it to the tasks
     * @param tasks is the list where the tasks read are added.
     * @param in is the stream where the where tasks are saved.
     */
    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {
        try {
            DataInput i = new DataInputStream(in);
            int number_of_tasks = i.readInt();
            for (int j = 0; j < (number_of_tasks); j++) {
                int l_n = i.readInt();
                String name = "";
                for (int n = 0; n < l_n; n++) {
                    name = name + String.valueOf(i.readChar());
                }
                boolean activity = i.readBoolean();
                boolean repeat = i.readBoolean();
                LocalDateTime interval;
                LocalDateTime start;
                LocalDateTime end;
                Task t;
                if (repeat){
                    int y_i = i.readInt();
                    int mes_i = i.readInt();
                    int d_i = i.readInt();
                    int h_i = i.readInt();
                    int m_i = i.readInt();
                    int s_i = i.readInt();
                    int ns_i = i.readInt();
                    interval= LocalDateTime.of(y_i,mes_i,d_i,h_i,m_i,s_i,ns_i);
                    int y_s = i.readInt();
                    int mes_s = i.readInt();
                    int d_s = i.readInt();
                    int h_s = i.readInt();
                    int m_s = i.readInt();
                    int s_s = i.readInt();
                    int ns_s = i.readInt();
                    start = LocalDateTime.of(y_s,mes_s,d_s,h_s,m_s,s_s,ns_s);
                    int y_e = i.readInt();
                    int mes_e = i.readInt();
                    int d_e = i.readInt();
                    int h_e = i.readInt();
                    int m_e = i.readInt();
                    int s_e = i.readInt();
                    int ns_e = i.readInt();
                    end = LocalDateTime.of(y_e,mes_e,d_e,h_e,m_e,s_e,ns_e);
                    t = new Task(name,start,end,interval);
                }else{
                    int y_t = i.readInt();
                    int mes_t = i.readInt();
                    int d_t = i.readInt();
                    int h_t = i.readInt();
                    int m_t = i.readInt();
                    int s_t = i.readInt();
                    int ns_t = i.readInt();
                    start = LocalDateTime.of(y_t,mes_t,d_t,h_t,m_t,s_t,ns_t);
                    t = new Task(name,start);
                }
                t.setActive(activity);
                tasks.add(t);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * writes the tasks from the list to the file
     * @param tasks is list of tasks to be written.
     * @param file is the file where the tasks are saved.
     */
    public static void writeBinary(AbstractTaskList tasks, File file ){
        try{
            OutputStreamWriter output = new FileWriter(file);
            output.write(tasks.size());
            tasks.getStream().forEach(element->{
                try {
                    output.write(element.getTitle().length());
                    output.write(element.getTitle());
                    output.write(element.isActive() ? 1 : 0);
                    output.write(element.isRepeated()? 1 : 0);
                    if (element.isRepeated()){
                        output.write(element.getRepeatInterval().getYear());
                        output.write(element.getRepeatInterval().getMonthValue());
                        output.write(element.getRepeatInterval().getDayOfMonth());
                        output.write(element.getRepeatInterval().getHour());
                        output.write(element.getRepeatInterval().getMinute());
                        output.write(element.getRepeatInterval().getSecond());
                        output.write(element.getRepeatInterval().getNano());

                        output.write(element.getStartTime().getYear());
                        output.write(element.getStartTime().getMonthValue());
                        output.write(element.getStartTime().getDayOfMonth());
                        output.write(element.getStartTime().getHour());
                        output.write(element.getStartTime().getMinute());
                        output.write(element.getStartTime().getSecond());
                        output.write(element.getStartTime().getNano());

                        output.write(element.getEndTime().getYear());
                        output.write(element.getEndTime().getMonthValue());
                        output.write(element.getEndTime().getDayOfMonth());
                        output.write(element.getEndTime().getHour());
                        output.write(element.getEndTime().getMinute());
                        output.write(element.getEndTime().getSecond());
                        output.write(element.getEndTime().getNano());
                    }else{
                        output.write(element.getTime().getYear());
                        output.write(element.getTime().getMonthValue());
                        output.write(element.getTime().getDayOfMonth());
                        output.write(element.getTime().getHour());
                        output.write(element.getTime().getMinute());
                        output.write(element.getTime().getSecond());
                        output.write(element.getTime().getNano());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads the tasks from the file and add theme to the list.
     * @param tasks is the tasks list where the tasks are going be added.
     * @param file is the file where the tasks are saved.
     * @throws IOException in case that something is wrong with the file.
     */
    public static void readBinary(AbstractTaskList tasks, File file) throws IOException {
        InputStreamReader input = new FileReader(file);
        int num = input.read();
        for(int i = 0; i<num; i++){
            int titleLength = input.read();
            String title = "";
            for(int q = 0; q<titleLength; q++){
                char c = (char)input.read();
                title += c;
            }
            boolean active = input.read() == 1;
            boolean repeat = input.read() ==1;
            LocalDateTime start = null;
            LocalDateTime end = null;
            LocalDateTime interval = null;
            Task t;
            if(repeat){
                for (int l = 0; l<3; l++){
                    int i_y = input.read();
                    int i_month = input.read();
                    int i_d = input.read();
                    int i_h = input.read();
                    int i_min = input.read();
                    int i_s = input.read();
                    int i_ns = input.read();
                    if(l == 0 )
                        interval = LocalDateTime.of(i_y,i_month,i_d,i_h,i_min,i_s,i_ns);
                    if(l==1)
                        start = LocalDateTime.of(i_y,i_month,i_d,i_h,i_min,i_s,i_ns);
                    if(l==2)
                        end = LocalDateTime.of(i_y,i_month,i_d,i_h,i_min,i_s,i_ns);
                }
                t = new Task(title,start,end,interval);
                t.setActive(active);
            }else{
                int t_y = input.read();
                int t_month = input.read();
                int t_d = input.read();
                int t_h = input.read();
                int t_min = input.read();
                int t_s = input.read();
                int t_ns = input.read();
                start = LocalDateTime.of(t_y,t_month,t_d,t_h,t_min,t_s,t_ns);
                t = new Task(title, start);
                t.setActive(active);
            }
            tasks.add(t);
        }
    }

    /**
     * writes the tasks of the list  to the stream in Json format.
     * @param tasks is list of tasks to be written.
     * @param out the stream where the tasks will be written.
     * @throws IOException in case that something is wrong with the file.
     */
    public static void write(AbstractTaskList tasks, Writer out) throws IOException {
        Gson gson = new Gson();
        try{
            String json = "";// gson.toJson(tasks);
            for (int i = 0; i< tasks.size(); i++){
                json += gson.toJson(tasks.getTask(i));
            }
            out.write(json);
        }catch (Exception e){

        }
        out.close();
    }

    /**
     * reads the tasks from the file and add theme to the list.
     * @param tasks is the tasks list where the tasks are going be added.
     * @param in is the file where the tasks are saved.
     * @throws IOException in case that something is wrong with the file.
     * @throws Exception
     */
    public static void read(AbstractTaskList tasks, Reader in) throws IOException, Exception {
        Gson gson = new Gson();
        try{
            int l = in.read();
            String s = "" + (char)l;
            int aux = (l==123)? 1 : 0;
            while(l != (-1)){
                l =in.read();
                s+= (char)l;
                if(l==123)
                    aux++;
                if(l == 125)
                    aux--;
                if (aux==0 && l!=-1){
                    Task p = gson.fromJson(s,Task.class);
                    tasks.add(p);
                    s = "";
                }
            }
        }catch (Exception e){
            throw new Exception("Something is wrong with Json format");
        }

    }

    /**
     * writes the tasks of the list  to the file in Json format.
     * @param tasks is list of tasks to be written.
     * @param out the file where the tasks will be written.
     * @throws IOException in case that something is wrong with the file.
     */
    public static void writeText(AbstractTaskList tasks, File file) throws IOException {
        try{
            FileWriter o = new FileWriter(file);
            Gson gson = new Gson();
            String s = "";
            for(int i = 0; i<tasks.size(); i++){
                s = gson.toJson(tasks.getTask(i));
                o.write(s);
            }
            o.close();
        }catch (Exception e){
            throw new IOException("something went wrong with the file");
        }
    }

    /**
     * reads the tasks from the file and add theme to the list.
     * @param tasks is the tasks list where the tasks are going be added.
     * @param in is the file where the tasks are saved.
     * @throws IOException in case that something is wrong with the file.
     * @throws Exception
     */
    public static void readText(AbstractTaskList tasks, File file) throws IOException {
        FileReader i = new FileReader(file);
        try{
            Gson gson =  new Gson();
            int l = i.read();
            String s = "" + (char)l;
            int aux = (l==123)? 1 : 0;
            while(l != (-1)){
                l =i.read();
                s+= (char)l;
                if(l==123)
                    aux++;
                if(l == 125)
                    aux--;
                if (aux==0 && l!=-1){
                    Task p = gson.fromJson(s,Task.class);
                    tasks.add(p);
                    s = "";
                }
            }

        }catch (Exception e){
            throw  new IOException("something is wrong with the file");
        }
        i.close();
    }


}
