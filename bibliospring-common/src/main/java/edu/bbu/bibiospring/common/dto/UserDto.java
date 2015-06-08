package edu.bbu.bibiospring.common.dto;

/**
 *
 * @author zsvitalyos
 */
public class UserDto extends DataTransferObject {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;

    public UserDto() {
        super(UserDto.class.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
