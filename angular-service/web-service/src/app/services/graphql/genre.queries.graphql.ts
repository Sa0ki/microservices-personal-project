import gql from "graphql-tag";

const GET_GENRE = gql`
  query{
    getGenresWithContents{
      id,
      name
    }
  }
`
const POST_GENRE = gql`
  mutation(
    $name: String
  ){
    addGenre(genreInput:{
      name: $name
    }){
      name
    }
  }
`
export { GET_GENRE, POST_GENRE }
