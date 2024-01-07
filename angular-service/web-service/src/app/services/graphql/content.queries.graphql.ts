import gql from "graphql-tag";

const GET_CONTENTS = gql`
  query{
    getContents{
      image,
      title,
      genresNames,
      year,
      comments{
        message
      },
      ratings{
        stars
      }
    }
  }
`
const POST_CONTENT = gql`
  mutation(
    $title: String,
    $year: Int,
    $image: String,
    $genresIds: [String]
  ){
    addContent(contentInput:{
      title: $title,
      year: $year,
      genresIds: $genresIds
      image: $image
    }){
      title,
      year,
      image,
      genresNames,
      comments{
        message
      },
      ratings{
        stars
      }
    }
  }
`
export { GET_CONTENTS, POST_CONTENT }
