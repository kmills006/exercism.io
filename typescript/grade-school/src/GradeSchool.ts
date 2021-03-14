// type Maybe<T> = T | undefined;
type StudentName = string;
type Grade = number | string;
type StudentsInGrade = StudentName[];
type StudentRoster = Map<Grade, StudentsInGrade>;

type GradeSchool = {
  addStudent: (name: StudentName, grade: Grade) => void;
  studentRoster: () => StudentRoster;
  studentsInGrade: (grade: Grade) => StudentsInGrade;
};

const studentsInGrade = (roster: StudentRoster) => (
  grade: Grade
): StudentsInGrade => [...roster.get(grade.toString()) || []];

const isAlreadyEnrolled = (roster: StudentRoster) => (
  name: StudentName
): boolean => {
  for (const students of roster.values()) {
    if (students.includes(name)) {
      return true;
    }
  }

  return false;
};

const removeFromGrade = (roster: StudentRoster) => (
  name: StudentName
): void => {
  for (const [grade, students] of roster.entries()) {
    if (students.includes(name)) {
      roster.set(
        grade.toString(),
        students.filter((n) => n !== name)
      );
    }
  }
};

export const gradeSchool = (
  roster: StudentRoster = new Map()
) => (): GradeSchool => ({
  addStudent: (name, grade): void => {
    const students = studentsInGrade(roster)(grade);

    if (isAlreadyEnrolled(roster)(name)) {
      removeFromGrade(roster)(name);
    }

    roster.set(grade.toString(), [...students, name].sort());
  },

  studentRoster: (): StudentRoster =>  new Map(
    [...roster.entries()].map(([g, s]) => [g, [...s]]),
  ),

  studentsInGrade: studentsInGrade(roster),
});
