// type Maybe<T> = T | undefined;
type StudentName = string;
type Grade = number;
type StudentsInGrade = StudentName[];
type StudentRoster = Map<Grade, StudentsInGrade>;

interface IGradeSchool {
  addStudent: (name: StudentName, grade: Grade) => void;
  studentRoster: () => StudentRoster;
  studentsInGrade: (grade: Grade) => StudentsInGrade;
}

class GradeSchool implements IGradeSchool {
  private _studentRoster: StudentRoster = new Map();

  public addStudent(name: StudentName, grade: Grade): void {
    const isAllowedToEnroll = this.isStudentAlreadyEnrolled(name);

    if (isAllowedToEnroll) {
      const classmates = this.studentsInGrade(grade);
      this._studentRoster.set(grade, [...classmates, name]);
    }

    console.log('this._studentRoster', this._studentRoster);
  }

  public studentRoster(): StudentRoster {
    return this._studentRoster;
  }

  private studentsInGrade(grade: Grade): StudentsInGrade {
    return this._studentRoster.get(grade) || [];
  }

  private isStudentAlreadyEnrolled(name: StudentName): [Grade, StudentName] {
    for (const grade of this._studentRoster.values()) {
      if (grade.includes(name)) {
        return false;
      }
    }

    return true;
  }

  // public studentsInGrade(grade: Grade): Students {
  //   // return this.getStudentsInGrade(grade);
  // }

  // private getStudentsInGrade(grade: Grade): Students {
  //   return this._studentRoster.get(grade) || [];
  // }

  // private isStudentAlreadyEnrolled(name: StudentName): boolean {
  //   for (const value of this._studentRoster.values()) {
  //     if (value.includes(name)) {
  //       return true;
  //     }
  //   }

  //   return false;
  // }
}

export default GradeSchool;
