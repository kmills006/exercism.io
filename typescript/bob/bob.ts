enum TeenagerResponse {
  BlanketStatement = 'Whatever.',
  ForcefulQuestion = 'Calm down, I know what I\'m doing!',
  Question = 'Sure.',
  Silence = 'Fine. Be that way!',
  Yelling = 'Whoa, chill out!',
}

type DetermineStatement = (statement: string) => boolean;

const isShouting: DetermineStatement = (statement) => (
  (statement === statement.toUpperCase()) && /[a-zA-Z]/.test(statement)
);

const isQuestion: DetermineStatement = (statement) => statement.endsWith('?');

export const speakToBob = (statement: string): TeenagerResponse => {
  const trimmed = statement.trim();

  if (!trimmed) {
    return TeenagerResponse.Silence;
  } else if (isShouting(trimmed) && isQuestion(trimmed)) {
    return TeenagerResponse.ForcefulQuestion;
  } else if (isShouting(trimmed)) {
    return TeenagerResponse.Yelling;
  } else if (isQuestion(trimmed)) {
    return TeenagerResponse.Question;
  }

  return TeenagerResponse.BlanketStatement;
};
