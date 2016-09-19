package restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import restaurant.model.Employee;
import restaurant.service.EmployeeService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

@RestController
public class FileController {

    private UploadedFile file;
    private EmployeeService employeeService;

    public FileController(){
        System.out.println("init RestController");
        file = new UploadedFile();
    }

    @RequestMapping(value = "/admin/employees/photoUpload/name={name}, surname={surname}", method = RequestMethod.POST)
    public void upload(MultipartHttpServletRequest request, HttpServletResponse response,
                       @PathVariable String name, @PathVariable String surname) {

        Iterator<String> itr =  request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() +" uploaded!");

        try {
            file.setLength(mpf.getBytes().length);
            file.setBytes(mpf.getBytes());
            file.setType(mpf.getContentType());
            file.setName(mpf.getOriginalFilename());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Employee employee = employeeService.getEmployeeByNameSurname(name, surname);
        employee.setPhoto(file.getBytes());
        employeeService.createOrUpdateEmployee(employee);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private class UploadedFile {

        private int length;
        private byte[] bytes;
        private String name;
        private String type;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public byte[] getBytes() {
            return bytes;
        }

        public void setBytes(byte[] bytes) {
            this.bytes = bytes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "UploadedFile{" +
                    "length=" + length +
                    ", bytes=" + Arrays.toString(bytes) +
                    ", name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}

