<template>

    <div>
        <div class="detail-title">
        Photo
        </div>
        <v-col>
            <String label="ImgName" v-model="value.imgName" :editMode="editMode"/>
            <LargeObject label="ImgFile" v-model="value.imgFile" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'Photo',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: '',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

