<template>

    <v-data-table
        :headers="headers"
        :items="productQuery"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ProductQueryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            productQuery : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/productQueries'))

            temp.data._embedded.productQueries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.productQuery = temp.data._embedded.productQueries;
        },
        methods: {
        }
    }
</script>

