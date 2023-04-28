package entity;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table (name = "todolist")
public class Todolist implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = true)
    private int id;
    @Basic
    @Column(name = "todo")
    private String todo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todolist todolist = (Todolist) o;

        if (id != todolist.id) return false;
        if (todo != null ? !todo.equals(todolist.todo) : todolist.todo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (todo != null ? todo.hashCode() : 0);
        return result;
    }
}
