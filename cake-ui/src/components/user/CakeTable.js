import React from 'react'
import { Grid, Table, Header, Icon } from 'semantic-ui-react'
import CakeForm from '../misc/CakeForm'

function CakeTable({ cakes, cakeDescription, handleInputChange, handleCreateCake }) {
  let cakeList

  if (!cakes || cakes.length === 0) {
    cakeList = (
      <Table.Row key='no-cake'>
        <Table.Cell collapsing textAlign='center' colSpan='3'>No Cake</Table.Cell>
      </Table.Row>
    )
  } else {

    cakeList = cakes.map(cake => {
      return (
        <Table.Row key={cake.id}>
          <Table.Cell>{cake.title}</Table.Cell>
          <Table.Cell>{cake.description}</Table.Cell>
          <Table.Cell>{cake.image}</Table.Cell>
        </Table.Row>
      )
    })
  }

  return (
    <>
      <Grid stackable divided>
        <Grid.Row columns='2'>
          <Grid.Column width='3'>
            <Header as='h2'>
              <Header.Content>Cake List </Header.Content>
            </Header>
          </Grid.Column>
          <Grid.Column>
            <CakeForm
                cakeDescription={cakeDescription}
                handleInputChange={handleInputChange}
                handleCreateCake={handleCreateCake}
            />
          </Grid.Column>
        </Grid.Row>
      </Grid>

      <Table compact striped>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell width={5}>Title</Table.HeaderCell>
            <Table.HeaderCell width={6}>Description</Table.HeaderCell>
            <Table.HeaderCell width={5}>Image</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {cakeList}
        </Table.Body>
      </Table>
    </>
  )
}

export default CakeTable