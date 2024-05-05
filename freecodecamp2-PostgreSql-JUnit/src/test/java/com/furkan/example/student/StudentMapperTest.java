package com.furkan.example.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("John",
                "Doe",
                "johndoe@gmail.com",
                1);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(),student.getSchool().getId());
    }

    //Bu kodda Student mapper dosyasındaki if ile aynı yazıyı yazmak zorunda yoksa hata verir.
    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
       var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exp.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentDto() {
        //Given
        Student student = new Student(
                "Jane",
                "Smith",
                "jane@gmail.com",
                20
        );

        //When
        StudentResponseDto response = mapper.toStudentResponseDto(student);

        //Then
        assertEquals(response.firstname(),student.getFirstname());
        assertEquals(response.lastname(),student.getLastname());
        assertEquals(response.email(),student.getEmail());
    }

















//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Inside the before all method");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Inside the after all method");
//    }
//
//
//    @BeforeEach
//    void setUp() {
//       System.out.println("Inside the before each method");
//    }
//
//    @AfterEach
//    void tearDown(){
//        System.out.println("Inside the after each method");
//    }
//
//    @Test
//    public void testMethod1(){
//        System.out.println("My first test method");
//    }
//
//    @Test
//    public void testMethod2(){
//        System.out.println("My second test method");
//    }

}