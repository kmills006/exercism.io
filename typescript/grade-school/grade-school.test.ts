import { gradeSchool } from "./src/GradeSchool";

describe("School", () => {
  let systemUnderTest: ReturnType<typeof gradeSchool>;

  beforeEach(() => {
    systemUnderTest = gradeSchool();
  });

  it("a new school has an empty roster", () => {
    const actual = systemUnderTest().studentRoster().size === 0;

    expect(actual).toEqual(true);
  });

  it("A student can't be in two different grades", () => {
    systemUnderTest().addStudent("Aimee", 2);
    systemUnderTest().addStudent("Aimee", 1);

    const emptyGrade = systemUnderTest().studentsInGrade(2);
    expect(emptyGrade).toEqual([]);
  });

  it("adding a student adds them to the roster for the given grade", () => {
    systemUnderTest().addStudent("Aimee", 2);

    const expectedDb = new Map(Object.entries({ 2: ["Aimee"] }));
    expect(systemUnderTest().studentRoster()).toEqual(expectedDb);
  });

  it("adding more students to the same grade adds them to the roster", () => {
    systemUnderTest().addStudent("Blair", 2);
    systemUnderTest().addStudent("James", 2);
    systemUnderTest().addStudent("Paul", 2);

    const expectedDb = new Map(
      Object.entries({ 2: ["Blair", "James", "Paul"] })
    );
    expect(systemUnderTest().studentRoster()).toEqual(expectedDb);
  });

  it("adding students to different grades adds them to the roster", () => {
    systemUnderTest().addStudent("Chelsea", 3);
    systemUnderTest().addStudent("Logan", 7);

    const expectedDb = new Map(
      Object.entries({ 3: ["Chelsea"], 7: ["Logan"] })
    );
    expect(systemUnderTest().studentRoster()).toEqual(expectedDb);
  });

  it("grade returns the students in that grade in alphabetical order", () => {
    systemUnderTest().addStudent("Franklin", 5);
    systemUnderTest().addStudent("Bradley", 5);
    systemUnderTest().addStudent("Jeff", 1);

    const expectedStudents = ["Bradley", "Franklin"];
    expect(systemUnderTest().studentsInGrade(5)).toEqual(expectedStudents);
  });

  it("grade returns an empty array if there are no students in that grade", () => {
    expect(systemUnderTest().studentsInGrade(1)).toEqual([]);
  });

  it("the students names in each grade in the roster are sorted", () => {
    systemUnderTest().addStudent("Jennifer", 4);
    systemUnderTest().addStudent("Kareem", 6);
    systemUnderTest().addStudent("Christopher", 4);
    systemUnderTest().addStudent("Kyle", 3);

    const expectedSortedStudents = new Map(
      Object.entries({
        3: ["Kyle"],
        4: ["Christopher", "Jennifer"],
        6: ["Kareem"],
      })
    );
    expect(systemUnderTest().studentRoster()).toEqual(expectedSortedStudents);
  });

  it("roster cannot be modified outside of module", () => {
    systemUnderTest().addStudent("Aimee", 2);
    const roster = systemUnderTest().studentRoster();
    const result = roster.get("2") || [];
    result.push("Oops.");
    const expectedDb = new Map(Object.entries({ 2: ["Aimee"] }));
    expect(systemUnderTest().studentRoster()).toEqual(expectedDb);
  });

  it("roster cannot be modified outside of module using studentsInGrade()", () => {
    systemUnderTest().addStudent("Aimee", 2);
    systemUnderTest().studentsInGrade(2).push("Oops.");
    const expectedDb = new Map(Object.entries({ 2: ["Aimee"] }));
    expect(systemUnderTest().studentRoster()).toEqual(expectedDb);
  });
});
